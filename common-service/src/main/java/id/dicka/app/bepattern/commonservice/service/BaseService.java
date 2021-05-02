package id.dicka.app.bepattern.commonservice.service;

import id.dicka.app.bepattern.commonservice.base.BaseRequest;
import id.dicka.app.bepattern.commonservice.base.BaseResponse;

public interface BaseService <REQUEST extends BaseRequest, RESPONSE extends BaseResponse> {

    RESPONSE execute(REQUEST request);

}
