package com.example.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {
	@Autowired
	StudentMapper studentMapper;
	// 전체출력
	public List<Student> getAll(){
		return studentMapper.selectAll();
	}
	// 한명 출력
	public Student getOneByName(String name) {
		return studentMapper.selectOneByName(name);
	}
	// 추가
	public int add(Student student) {
		return studentMapper.insert(student);
	}
	// 수정
	public int modify(Student student) {
		return studentMapper.update(student);
	}
	// 삭제
	public int remove(String name) {
		return studentMapper.delete(name);
	}
}
