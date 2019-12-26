package com.betuls.feedrabbit;

import java.util.*;

public class fallar {
    Random randSayi = new Random();
    int random = randSayi.nextInt(21);
    String fal = new String();

    public String falCek() {
        switch (random){
            case 1:
                fal = "Askin etmis onu sair,Her gün yazar bir siir,Sensin ilham perisi,Tum satirlar sana dair";
                break;
            case 2:
                fal = "Fazla sey beklemez senden,Ister hayatinda cekiduzen,Evliliktir bunun sonu,Seversen onu gonulden";
                break;
            case 3:
                fal = "Boynunda var bir kolye,Iki resim bagli zincire,Biri o digeri sen,Acar bakar her saniye";
                break;
            case 4:
                fal = "Atmissin ona bir bakis,Gozlerine tutulmus kalmis,Kendini bulmus o anda,Askin ona pek yaramis";
                break;
            case 5:
                fal = "Senden bekler hareket,Edemez konusmaya cesaret,Sen bir adim atsan ona,O on adim gelecek";
                break;
            case 6:
                fal = "Bir gorunup bir kayboluyor,Onu yakalamak zor mu zor,Goremeyince uzuluyorsun,Senin de yuregine dusmus kor";
                break;
            case 7:
                fal = "Duy su carpan kalbin sesini,Sanki soyler senin ismini,O hep boyle carpacak,Surecek aski ebedi";
                break;
            case 8:
                fal = "Her gun bakar aynaya,Guzel gorunmek icin sana,Begendirecek kendini,Gelirseniz yan yana";
                break;
            case 9:
                fal = "Bir ev dosemis zevki super,Bazen pop bazen caz dinler,Hayvanlara sevgisinden,Okumus olmus veteriner";
                break;
            case 10:
                fal = "Onunla tez geciyor saat,Konusmaya kalmiyor firsat,Sana soyleyecekleri var,Bu kez zamani sen ayir";
                break;
            case 11:
                fal = "Sevdigin biraz duygusal,Askiniz guzel bir masal,Nazik davran aman ona,Kalbi sanki kristal";
                break;
            case 12:
                fal = "Aranizda var bir resmiyet,Ama degisecek bu vaziyet,Cok uzun surmeyecek,Olusacak samimiyet";
                break;
            case 13:
                fal = "Suya muhtactir her yonca,Anlarsin yalniz kalinca,Tatsizliklar atlatilir,Bir taraf alttan alinca";
                break;
            case 14:
                fal = "En onemli vasfi sabir,Dur durak bilmeden calisir,Bir ikinci lig kulubunde,Futbol oynuyor bes yildir";
                break;
            case 15:
                fal = "Seni senden cok sever,Iste dunyayi ayagina serer,Seni guzel yasatacak,Vermeyecek hic keder";
                break;
            case 16:
                fal = "Askta olmaz gurur,O sana sen ona mecbur,Hatasini affettiginde,Bulacaksiniz birlikte huzur";
                break;
            case 17:
                fal = "Sabrin sonu selamet,Bu iste var keramet,Hemen pes etmezsen,Kuracaksiniz muhabbet";
                break;
            case 18:
                fal = "Siz tanisali uç gun olmus,Kalbine bir sicaklik dolmus,Tekrar gorusur muyuz diye,Zavallim sararip solmus";
                break;
            case 19:
                fal = "Dinliyor kalbinin sesini,Kapatip guzel gozlerini,Dusunuyor saatlerce,Sensin en buyuk hayali";
                break;
            case 20:
                fal = "Ask basliyor yeni yeni,O tanimak istiyor seni,Size neler getirecek,Bu güzel ask seruveni";
                break;

        }

        String falMetni = new String();
        falMetni = fal.replaceAll(",", "\n");
        return falMetni;
    }
}


