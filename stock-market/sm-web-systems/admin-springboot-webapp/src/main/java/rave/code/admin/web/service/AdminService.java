package rave.code.admin.web.service;

import rave.code.entity.quartz.QuartzJobDetailEntity;
import rave.code.repository.quartz.QuartzJobDetailRepository;

import java.util.List;

public class AdminService {

    private QuartzJobDetailRepository quartzJobDetailRepository = new QuartzJobDetailRepository();

    public List<QuartzJobDetailEntity> quartzJobDetails(){
        return quartzJobDetailRepository.findAll();
    }
}
