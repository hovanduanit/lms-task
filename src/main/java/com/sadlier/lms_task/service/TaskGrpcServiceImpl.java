package com.sadlier.lms_task.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import proto.common.IdReq;
import proto.common.Pageable;
import proto.common.UpsertResp;
import proto.service.shared.Status;
import proto.service.shared.Task;
import proto.service.task.ListTaskResp;

import java.util.List;
import java.util.UUID;

@Service
public class TaskGrpcServiceImpl implements ITaskGrpcService{
    @Override
    public UpsertResp upsertTask(Task request) {
        return UpsertResp.newBuilder()
                .setData(UpsertResp.Data.newBuilder()
                        .setId(StringUtils.defaultIfEmpty(request.getId(), UUID.randomUUID().toString()))
                        .build())
                .build();
    }

    @Override
    public ListTaskResp listTask(Pageable request) {
        return ListTaskResp.newBuilder()
                .setData(ListTaskResp.Data.newBuilder()
                        .addAllTasks(List.of(
                                Task.newBuilder()
                                        .setId(UUID.randomUUID().toString())
                                        .setName("Task 1")
                                        .setStatus(Status.STATUS_PENDING)
                                        .build(),
                                Task.newBuilder()
                                        .setId(UUID.randomUUID().toString())
                                        .setName("Task 2")
                                        .setStatus(Status.STATUS_COMPLETED)
                                        .build(),
                                Task.newBuilder()
                                        .setId(UUID.randomUUID().toString())
                                        .setName("Task 3")
                                        .setStatus(Status.STATUS_PROCESSING)
                                        .build()
                        ))
                        .build())
                .build();
    }

    @Override
    public Task getTask(IdReq request) {
        // TODO
        return null;
    }
}
