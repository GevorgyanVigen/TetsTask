package com.example.controller;

import com.example.repository.ClanManager;


public class ClanController {

    public synchronized void incGold(long clanId, int gold) {
        ClanManager.updateGold(clanId, gold);
    }
}


