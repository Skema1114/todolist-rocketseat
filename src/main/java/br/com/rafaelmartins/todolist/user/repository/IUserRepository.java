package br.com.rafaelmartins.todolist.user.repository;

import br.com.rafaelmartins.todolist.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<UserModel, UUID> {
 UserModel findByUsername(String username);
}
