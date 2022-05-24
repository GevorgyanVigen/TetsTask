package com.example.repository;

import com.example.model.Clan;
import com.example.util.HibernateUtil;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



@Data
public class ClanManager {

private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public synchronized static Clan getClan(long clanId) {
        Session session = sessionFactory.openSession();

        return session.find(Clan.class, clanId);
    }

    public synchronized static void saveClan(long clanId) {
        try {
            Session session = sessionFactory.openSession();

            Clan clan = new Clan();
            clan.setId(clanId);
            session.beginTransaction();
            session.save(clan);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public synchronized static void updateGold(Long clanId, int gold) {
        Clan clan = getClan(clanId);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        clan.setGold(clan.getGold() + gold);
        session.update(clan);
        session.getTransaction().commit();
        session.close();

    }
}


