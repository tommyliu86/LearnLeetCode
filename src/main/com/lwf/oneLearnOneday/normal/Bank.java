package com.lwf.oneLearnOneday.normal;

/**
 * Created with IntelliJ IDEA.
 *
 * https://leetcode-cn.com/problems/simple-bank-system/
 * 2043. 简易银行系统
 * @author: liuwenfei14
 * @date: 2022-03-18 10:56
 */
public class Bank {
    private volatile long[] balances;
    private int maxAccount;
    public Bank(long[] balance) {
        this.balances=balance;
        this.maxAccount=balances.length;
    }
    private boolean checkAccount(int account){
        return account>0&&account<=this.maxAccount;
    }
    private boolean checkMoney(int account,long money){
        return balances[account-1]<=money;

    }
    public boolean transfer(int account1, int account2, long money) {
        if (checkAccount(account1)&&checkAccount(account2)&&checkMoney(account1,money)){
            balances[account1-1]-=money;
            balances[account2-1]+=money;
            return true;
        }else{
            return false;
        }
    }

    public boolean deposit(int account, long money) {
        if (checkAccount(account)){

            balances[account-1]+=money;
            return true;
        }else{
            return false;
        }
    }

    public boolean withdraw(int account, long money) {
        if (checkAccount(account)&& checkMoney(account,money)){

            balances[account-1]-=money;
            return true;
        }else{
            return false;
        }
    }
}
