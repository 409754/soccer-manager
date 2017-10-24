package cz.muni.fi.pa165.soccermanager.dao;

import cz.muni.fi.pa165.soccermanager.entity.Team;

import java.util.List;

public interface TeamDao {
    Team fetchById(Long teamId);
    List<Team> fetchAll();
    void insert(Team team);
    void update(Team team);
    void delete(long teamId);
}
