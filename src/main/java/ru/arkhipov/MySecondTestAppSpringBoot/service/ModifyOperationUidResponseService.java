package ru.arkhipov.MySecondTestAppSpringBoot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.arkhipov.MySecondTestAppSpringBoot.model.Response;

import java.util.UUID;

@Slf4j
@Service
@Qualifier("ModifyOperationUidResponseService")
public class ModifyOperationUidResponseService implements ModifyResponseService {

    @Override
    public Response modify(Response response) {
        var uuid = UUID.randomUUID();

        var prevUid = response.getOperationUid();
        response.setOperationUid(uuid.toString());

        log.info("response['OperationUid'] changed from {} to {}", prevUid, response.getOperationUid());

        return response;
    }
}
