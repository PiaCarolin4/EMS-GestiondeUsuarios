package cl.duocuc.piperalta.ecomarketspa.repository;

import cl.duocuc.piperalta.ecomarketspa.domain.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRepository {
    private static final List<User> users = new ArrayList<>();

    static {
        users.addAll(
                List.of(
                        User.builder()
                                .name("Pia Carolina Peralta Leiva")
                                .rut("18764345-7")
                                .id("1")
                                .build(),
                        User.builder()
                                .name("Benjamín Andrés Aguilar Ledezma")
                                .rut("20428923-9")
                                .id("2")
                                .build(),
                        User.builder()
                                .name("Francisca Amanda Díaz Leiva")
                                .rut("20148035-3")
                                .id("3")
                                .build(),
                        User.builder()
                                .name("Javiera Cristina Cisternas Peralta")
                                .rut("21498292-2")
                                .id("4")
                                .build(),
                        User.builder()
                                .name("Dominga Aimara Calderón Peralta")
                                .rut("24239229-4")
                                .id("5")
                                .build(),
                        User.builder()
                                .name("Fabio Emilio Calderón Peralta")
                                .rut("10498292-2")
                                .id("6")
                                .build()));
    }

    public static List<User> findAll() {
        return users;
    }
}
