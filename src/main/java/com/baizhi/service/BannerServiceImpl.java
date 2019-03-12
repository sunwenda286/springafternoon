package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;
    public void addBanner(Banner banner){
        bannerDao.insert(banner);
    }
}
