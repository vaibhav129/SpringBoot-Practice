package com.example.hibernate.dao;

import com.example.hibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentDAOimpl implements studentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student thestudent){
        entityManager.persist(thestudent);
    }

    @Override
    public Student findbyid(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findall() {
        TypedQuery<Student> thequery= entityManager.createQuery("FROM Student",Student.class);

        return thequery.getResultList();
    }

    @Override
    public List<Student> findbylast(String lastname) {
        TypedQuery<Student> quer=entityManager.createQuery("FROM Student WHERE lastname=:theData",Student.class);
         quer.setParameter("theData",lastname);
         return quer.getResultList();
    }

    @Override
    @Transactional
    public void update(Student thest) {
         entityManager.merge(thest);
    }

    @Override
    public void deletest(Integer id) {
        Student temp=entityManager.find(Student.class,id);
        entityManager.remove(temp);
    }

}
