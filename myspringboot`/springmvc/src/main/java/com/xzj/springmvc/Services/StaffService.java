package com.xzj.springmvc.Services;

import com.xzj.springmvc.Bean.Staff;
import com.xzj.springmvc.dao.StaffDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service

public class StaffService implements IStaffService{

    @Autowired
    StaffDAO staffDAO;

    @Override
    public Staff getStaffById(Integer id) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateStaff(Staff staff) {

    }
}
