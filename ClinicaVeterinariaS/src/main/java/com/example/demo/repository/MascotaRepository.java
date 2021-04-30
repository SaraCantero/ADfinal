package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Mascota;
import com.example.demo.entity.User;

@Repository("mascotaRepository")
public interface MascotaRepository extends JpaRepository<Mascota, Serializable> {
	public abstract List<Mascota> findByUser(User user);
	public abstract Mascota findById(int id);


}
