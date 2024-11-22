package com.sadlier.lms_task.service;


import proto.common.IdReq;
import proto.common.Pageable;
import proto.common.UpsertResp;
import proto.service.shared.Task;
import proto.service.task.ListTaskResp;

public interface ITaskGrpcService {
    UpsertResp upsertTask(Task request);

    ListTaskResp listTask(Pageable request);

    Task getTask(IdReq request);
}
