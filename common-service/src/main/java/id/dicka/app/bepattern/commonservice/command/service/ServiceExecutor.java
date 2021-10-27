package id.dicka.app.bepattern.commonservice.command.service;

import id.dicka.app.bepattern.commonservice.command.Command;
import id.dicka.app.bepattern.commonservice.command.service.ServiceRequest;

public interface ServiceExecutor {

    <T,R extends ServiceRequest> T execute(Class<? extends Command<T, R>> commandClass, R request);

}
