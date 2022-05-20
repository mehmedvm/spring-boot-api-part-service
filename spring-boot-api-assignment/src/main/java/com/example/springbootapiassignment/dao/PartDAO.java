package com.example.springbootapiassignment.dao;

import com.example.springbootapiassignment.entity.Part;
import java.util.List;

public interface PartDAO {
    List<Part> findAll();
    Part findById(int theId);
    void saveOrUpdate(Part thePart);
    void deleteById(int theId);

}
