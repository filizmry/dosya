package banka;


import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.Scanner;

public class Bank {


    public void getAccount(){

        System.out.println(Account.hesapList);

    }

    public void getDate(){
        GregorianCalendar date = new GregorianCalendar();

        int  day = date.get(Calendar.DAY_OF_MONTH);
        int   month = date.get(Calendar.MONTH);
        int  year = date.get(Calendar.YEAR);

        int second = date.get(Calendar.SECOND);
        int  minute = date.get(Calendar.MINUTE);
        int  hour = date.get(Calendar.HOUR);

        System.out.println("Tarih  "+day+"/"+(month+1)+"/"+year);
        System.out.println("Saat:  "+hour+" : "+minute+" : "+second);

    }






    public void menu(){
        System.out.println("1-Cari hesab işlemleri\n2-Kısa Vadeli \n3-Uzun Vadeli " +
                "\n4-Özel Hesap");
        Scanner scan=new Scanner(System.in);
        int secim=scan.nextInt();
        switch (secim){
            case 1:Account accountCari=new Cari();
                Account.hesapList.add(accountCari);
                System.out.println("Yapmak istediğiniz işlem: ");

                System.out.println("1-Para Ekle\n2-Para Çek");
                int sec=scan.nextInt();
                if (sec==1){
                    accountCari.deposit();
                }if (sec==2){
                    accountCari.withdraw();
            }
                menu();
                break;

            case 2: Account accountKisa=new KisaVadeli();
                Account.hesapList.add(accountKisa);

                accountKisa.Benefit();
                menu();
                break;
            case 3: Account accountUzun=new UzunVadeli();
                Account.hesapList.add(accountUzun);
                accountUzun.bakiye=5000;
                accountUzun.Benefit();
                menu();
                break;
            case 4: Account accountOzel=new Ozel();
                Account.hesapList.add(accountOzel);
                accountOzel.Benefit();
                menu();
                break;
            default:System.exit(0);

        }

    }

}
