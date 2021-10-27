package id.dicka.app.bepattern.commonservice.command;

import id.dicka.app.bepattern.commonservice.command.service.ServiceRequest;

public interface Command<RESULT, REQUEST extends ServiceRequest> {

    RESULT execute(REQUEST request);

}
