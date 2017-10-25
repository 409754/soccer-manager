package cz.muni.fi.pa165.soccermanager.dao;

import cz.muni.fi.pa165.soccermanager.entity.Match;

import java.util.List;


public interface MatchDao {
    /**
     * @return found match if exists, null otherwise
     */
    Match fetchById(long matchId);
    List<Match> fetchAll();
    void insert(Match match);
    void update(Match match);
    void delete(long matchId);
}
