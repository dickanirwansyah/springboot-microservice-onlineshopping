package id.dicka.app.bepattern.userservice.base;

import id.dicka.app.bepattern.commonservice.service.BasePagingService;
import id.dicka.app.bepattern.commonservice.util.PageableUtil;
import id.dicka.app.bepattern.userservice.base.repository.MstUsersRepository;
import id.dicka.app.bepattern.userservice.base.request.ListUserRequest;
import id.dicka.app.bepattern.userservice.base.response.ContentUser;
import id.dicka.app.bepattern.userservice.base.response.ListUserResponse;
import id.dicka.app.bepattern.userservice.base.view.UserView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListBaseUser extends BasePagingService<ListUserRequest, ListUserResponse> {

    private static final String DEFAULT_USER_ID = "user_id";
    private MstUsersRepository mstUsersRepository;
    public ListBaseUser(MstUsersRepository mstUsersRepository){
        this.mstUsersRepository = mstUsersRepository;
    }

    @Override
    public ListUserResponse execute(ListUserRequest request) {
        Page<UserView> userViews = listUserPage(request);
        List<ContentUser> contentUsers = userViews.getContent()
                .stream()
                .map(user -> ContentUser.builder()
                        .userId(user.getUserId())
                        .name(user.getName())
                        .build())
                .collect(Collectors.toList());

        ListUserResponse listUserResponse = new ListUserResponse();
        listUserResponse.setContent(contentUsers);
        listUserResponse.setPagination(PageableUtil.pageToPagination(userViews));
        return listUserResponse;
    }

    private Page<UserView> listUserPage(ListUserRequest request){
        String sortBy = request.getSortBy() != null && !request.getSortBy().isEmpty() ? request.getSortBy() : DEFAULT_USER_ID ;
        Pageable pageableRequest = PageableUtil.createPageRequest(request, getPageSize(), getPageNumber(), sortBy, getSortType());
        Page<UserView> filterUser = null;

        if (request.getName() != null || request.getUserId() != null){
            filterUser = mstUsersRepository.fetchingUsersByUserIdAndName(request.getUserId(), request.getName(), pageableRequest);
        }else{
            filterUser = mstUsersRepository.fetchingUserAll(pageableRequest);
        }
        return filterUser;
    }
}
