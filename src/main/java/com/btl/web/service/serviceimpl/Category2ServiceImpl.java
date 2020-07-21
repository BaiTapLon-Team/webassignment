package com.btl.web.service.serviceimpl;

import com.btl.web.entity.Category2;
import com.btl.web.reponsitory.Category2Reponsitory;
import com.btl.web.service.Category2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Category2ServiceImpl implements Category2Service {

    @Autowired
    private Category2Reponsitory category2Reponsitory;

    @Override
    public List<Category2> findAll () {
        return category2Reponsitory.findAll();
    }

    @Override
    public Optional<Category2> findCategory2ById ( Integer id ) {
        return category2Reponsitory.findById(id);
    }
}
