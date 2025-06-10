package main;

import org.bukkit.entity.Player;

import java.util.LinkedHashMap;
import java.util.Map;
import main.main;
import org.jetbrains.annotations.NotNull;

import static main.database.AliasDB.*;


public class Alias {
    private static final Map<String, String> languageRU = new LinkedHashMap<>();
    private static final Map<String, String> languageEN = new LinkedHashMap<>();


    public static Double exchange(String firstVault, Double firstValue , String secondVault) {
        if (!(
                firstVault.equals("PESO") ||
                firstVault.equals("DOLLAR") ||
                firstVault.equals("EURO") ||
                firstVault.equals("REAL") ||
                firstVault.equals("YUAN'") ||
                firstVault.equals("FRANK") ||
                firstVault.equals("RUPEE") ||
                secondVault.equals("PESO") ||
                secondVault.equals("DOLLAR") ||
                secondVault.equals("EURO") ||
                secondVault.equals("REAL") ||
                secondVault.equals("YUAN'") ||
                secondVault.equals("FRANK") ||
                secondVault.equals("RUPEE")
        )) {
            main.getInstance().getLogger().info("Валюта не являются валютой, ошибка мозга разработчика");
            return null;
        }
        Double secondValue = firstValue / getCurrencyCoff(firstVault) * getCurrencyCoff(secondVault);
        return secondValue;
    }


    public static void initLanguage () {
        languageRU.put("Australia","Австралия");
        languageRU.put("Austria","Австрия");
        languageRU.put("Azerbaijan","Азербайджан");
        languageRU.put("Albania","Албания");
        languageRU.put("Algeria","Алжир");
        languageRU.put("Angola","Ангола");
        languageRU.put("Andorra","Андорра");
        languageRU.put("Argentina","Аргентина");
        languageRU.put("Armenia","Армения");
        languageRU.put("Afghanistan","Афганистан");
        languageRU.put("Bahamas","Багамские Острова");
        languageRU.put("Bangladesh","Бангладеш");
        languageRU.put("Barbados","Барбадос");
        languageRU.put("Bahrain","Бахрейн");
        languageRU.put("Belize","Белиз");
        languageRU.put("Belarus","Белоруссия");
        languageRU.put("Belgium","Бельгия");
        languageRU.put("Benin","Бенин");
        languageRU.put("Bulgaria","Болгария");
        languageRU.put("Bolivia","Боливия");
        languageRU.put("Bosnia and Herzegovina","Босния и Герцеговина");
        languageRU.put("Botswana","Ботсвана");
        languageRU.put("Brazil","Бразилия");
        languageRU.put("Brunei","Бруней");
        languageRU.put("Burkina Faso","Буркина-Фасо");
        languageRU.put("Burundi","Бурунди");
        languageRU.put("Butane","Бутан");
        languageRU.put("Vanuatu","Вануату");
        languageRU.put("United Kingdom","Великобритания");
        languageRU.put("Hungary","Венгрия");
        languageRU.put("Venezuela","Венесуэла");
        languageRU.put("East Timor","Восточный Тимор");
        languageRU.put("Vietnam","Вьетнам");
        languageRU.put("Gabon","Габон");
        languageRU.put("Haiti","Гаити");
        languageRU.put("Guyana","Гайана");
        languageRU.put("Gambia","Гамбия");
        languageRU.put("Ghana","Гана");
        languageRU.put("Guatemala","Гватемала");
        languageRU.put("Guinea","Гвинея");
        languageRU.put("Guinea-Bissau","Гвинея-Бисау");
        languageRU.put("Germany","Германия");
        languageRU.put("Honduras","Гондурас");
        languageRU.put("Grenada","Гренада");
        languageRU.put("Greece","Греция");
        languageRU.put("Georgia","Грузия");
        languageRU.put("Denmark","Дания");
        languageRU.put("Djibouti","Джибути");
        languageRU.put("Dominica","Доминика");
        languageRU.put("Dominican Republic","Доминиканская Республика");
        languageRU.put("DR Congo","ДР Конго");
        languageRU.put("Egypt","Египет");
        languageRU.put("Zambia","Замбия");
        languageRU.put("Zimbabwe","Зимбабве");
        languageRU.put("Israel","Израиль");
        languageRU.put("India","Индия");
        languageRU.put("Indonesia","Индонезия");
        languageRU.put("Jordan","Иордания");
        languageRU.put("Iraq","Ирак");
        languageRU.put("Iran","Иран");
        languageRU.put("Ireland","Ирландия");
        languageRU.put("Iceland","Исландия");
        languageRU.put("Spain","Испания");
        languageRU.put("Italy","Италия");
        languageRU.put("Yemen","Йемен");
        languageRU.put("Cape Verde","Кабо-Верде");
        languageRU.put("Kazakhstan","Казахстан");
        languageRU.put("Cambodia","Камбоджа");
        languageRU.put("Cameroon","Камерун");
        languageRU.put("Canada","Канада");
        languageRU.put("Qatar","Катар");
        languageRU.put("Kenya","Кения");
        languageRU.put("Cyprus","Кипр");
        languageRU.put("Kyrgyzstan","Киргизия");
        languageRU.put("Kiribati","Кирибати");
        languageRU.put("China","Китай");
        languageRU.put("DPRK","КНДР");
        languageRU.put("Colombia","Колумбия");
        languageRU.put("Costa Rica","Коста-Рика");
        languageRU.put("Cuba","Куба");
        languageRU.put("Kuwait","Кувейт");
        languageRU.put("Laos","Лаос");
        languageRU.put("Latvia","Латвия");
        languageRU.put("Lesotho","Лесото");
        languageRU.put("Liberia","Либерия");
        languageRU.put("Lebanon","Ливан");
        languageRU.put("Libya","Ливия");
        languageRU.put("Lithuania","Литва");
        languageRU.put("Liechtenstein","Лихтенштейн");
        languageRU.put("Luxembourg","Люксембург");
        languageRU.put("Mauritius","Маврикий");
        languageRU.put("Mauritania","Мавритания");
        languageRU.put("Madagascar","Мадагаскар");
        languageRU.put("Malawi","Малави");
        languageRU.put("Malaysia","Малайзия");
        languageRU.put("Mali","Мали");
        languageRU.put("Maldives","Мальдивские Острова");
        languageRU.put("Malta","Мальта");
        languageRU.put("Morocco","Марокко");
        languageRU.put("Mexico","Мексика");
        languageRU.put("Mozambique","Мозамбик");
        languageRU.put("Moldova","Молдавия");
        languageRU.put("Monaco","Монако");
        languageRU.put("Mongolia","Монголия");
        languageRU.put("Myanmar","Мьянма");
        languageRU.put("Namibia","Намибия");
        languageRU.put("Nauru","Науру");
        languageRU.put("Nepal","Непал");
        languageRU.put("Niger","Нигер");
        languageRU.put("Nigeria","Нигерия");
        languageRU.put("Netherlands","Нидерланды");
        languageRU.put("Nicaragua","Никарагуа");
        languageRU.put("New Zealand","Новая Зеландия");
        languageRU.put("Norway","Норвегия");
        languageRU.put("UAE","ОАЭ");
        languageRU.put("Oman","Оман");
        languageRU.put("Pakistan","Пакистан");
        languageRU.put("Palau","Палау");
        languageRU.put("Panama","Панама");
        languageRU.put("Papua New Guinea","Папуа - Новая Гвинея");
        languageRU.put("Paraguay","Парагвай");
        languageRU.put("Peru","Перу");
        languageRU.put("Poland","Польша");
        languageRU.put("Portugal","Португалия");
        languageRU.put("Republic of Congo","Республика Конго");
        languageRU.put("Republic of Korea","Республика Корея");
        languageRU.put("Russia","Россия");
        languageRU.put("Rwanda","Руанда");
        languageRU.put("Romania","Румыния");
        languageRU.put("Salvador","Сальвадор");
        languageRU.put("Samoa","Самоа");
        languageRU.put("San Marino","Сан-Марино");
        languageRU.put("Saudi Arabia","Саудовская Аравия");
        languageRU.put("North Macedonia","Северная Македония");
        languageRU.put("Senegal","Сенегал");
        languageRU.put("Saint Lucia","Сент-Люсия");
        languageRU.put("Serbia","Сербия");
        languageRU.put("Singapore","Сингапур");
        languageRU.put("Syria","Сирия");
        languageRU.put("Slovakia","Словакия");
        languageRU.put("Slovenia","Словения");
        languageRU.put("Somalia","Сомали");
        languageRU.put("Sudan","Судан");
        languageRU.put("Suriname","Суринам");
        languageRU.put("USA","США");
        languageRU.put("Tajikistan","Таджикистан");
        languageRU.put("Thailand","Таиланд");
        languageRU.put("Tanzania","Танзания");
        languageRU.put("Togo","Того");
        languageRU.put("Tonga","Тонга");
        languageRU.put("Tuvalu","Тувалу");
        languageRU.put("Tunisia","Тунис");
        languageRU.put("Turkmenistan","Туркмения");
        languageRU.put("Türkiye","Турция");
        languageRU.put("Uganda","Уганда");
        languageRU.put("Uzbekistan","Узбекистан");
        languageRU.put("Ukraine","Украина");
        languageRU.put("Uruguay","Уругвай");
        languageRU.put("Fiji","Фиджи");
        languageRU.put("Philippines","Филиппины");
        languageRU.put("Finland","Финляндия");
        languageRU.put("France","Франция");
        languageRU.put("Croatia","Хорватия");
        languageRU.put("CAR","ЦАР");
        languageRU.put("Chad","Чад");
        languageRU.put("Montenegro","Черногория");
        languageRU.put("Czech Republic","Чехия");
        languageRU.put("Chile","Чили");
        languageRU.put("Switzerland","Швейцария");
        languageRU.put("Sweden","Швеция");
        languageRU.put("Sri Lanka","Шри-Ланка");
        languageRU.put("Ecuador","Эквадор");
        languageRU.put("Equatorial Guinea","Экваториальная Гвинея");
        languageRU.put("Eritrea","Эритрея");
        languageRU.put("Eswatini","Эсватини");
        languageRU.put("Estonia","Эстония");
        languageRU.put("Ethiopia","Эфиопия");
        languageRU.put("South Africa","ЮАР");
        languageRU.put("South Sudan","Южный Судан");
        languageRU.put("Jamaica","Ямайка");
        languageRU.put("Japan","Япония");
        //--------------------------------------------------
        languageRU.put("Berlin","Берлин");
        languageRU.put("Stavropol","Ставрополь");
        languageRU.put("Moscow","Москва");


        languageEN.put("Австралия","Australia");
        languageEN.put("Австрия","Austria");
        languageEN.put("Азербайджан","Azerbaijan");
        languageEN.put("Албания","Albania");
        languageEN.put("Алжир","Algeria");
        languageEN.put("Ангола","Angola");
        languageEN.put("Андорра","Andorra");
        languageEN.put("Аргентина","Argentina");
        languageEN.put("Армения","Armenia");
        languageEN.put("Афганистан","Afghanistan");
        languageEN.put("Багамские Острова","Bahamas");
        languageEN.put("Бангладеш","Bangladesh");
        languageEN.put("Барбадос","Barbados");
        languageEN.put("Бахрейн","Bahrain");
        languageEN.put("Белиз","Belize");
        languageEN.put("Белоруссия","Belarus");
        languageEN.put("Бельгия","Belgium");
        languageEN.put("Бенин","Benin");
        languageEN.put("Болгария","Bulgaria");
        languageEN.put("Боливия","Bolivia");
        languageEN.put("Босния и Герцеговина","Bosnia and Herzegovina");
        languageEN.put("Ботсвана","Botswana");
        languageEN.put("Бразилия","Brazil");
        languageEN.put("Бруней","Brunei");
        languageEN.put("Буркина-Фасо","Burkina Faso");
        languageEN.put("Бурунди","Burundi");
        languageEN.put("Бутан","Butane");
        languageEN.put("Вануату","Vanuatu");
        languageEN.put("Великобритания","United Kingdom");
        languageEN.put("Венгрия","Hungary");
        languageEN.put("Венесуэла","Venezuela");
        languageEN.put("Восточный Тимор","East Timor");
        languageEN.put("Вьетнам","Vietnam");
        languageEN.put("Габон","Gabon");
        languageEN.put("Гаити","Haiti");
        languageEN.put("Гайана","Guyana");
        languageEN.put("Гамбия","Gambia");
        languageEN.put("Гана","Ghana");
        languageEN.put("Гватемала","Guatemala");
        languageEN.put("Гвинея","Guinea");
        languageEN.put("Гвинея-Бисау","Guinea-Bissau");
        languageEN.put("Германия","Germany");
        languageEN.put("Гондурас","Honduras");
        languageEN.put("Гренада","Grenada");
        languageEN.put("Греция","Greece");
        languageEN.put("Грузия","Georgia");
        languageEN.put("Дания","Denmark");
        languageEN.put("Джибути","Djibouti");
        languageEN.put("Доминика","Dominica");
        languageEN.put("Доминиканская Республика","Dominican Republic");
        languageEN.put("ДР Конго","DR Congo");
        languageEN.put("Египет","Egypt");
        languageEN.put("Замбия","Zambia");
        languageEN.put("Зимбабве","Zimbabwe");
        languageEN.put("Израиль","Israel");
        languageEN.put("Индия","India");
        languageEN.put("Индонезия","Indonesia");
        languageEN.put("Иордания","Jordan");
        languageEN.put("Ирак","Iraq");
        languageEN.put("Иран","Iran");
        languageEN.put("Ирландия","Ireland");
        languageEN.put("Исландия","Iceland");
        languageEN.put("Испания","Spain");
        languageEN.put("Италия","Italy");
        languageEN.put("Йемен","Yemen");
        languageEN.put("Кабо-Верде","Cape Verde");
        languageEN.put("Казахстан","Kazakhstan");
        languageEN.put("Камбоджа","Cambodia");
        languageEN.put("Камерун","Cameroon");
        languageEN.put("Канада","Canada");
        languageEN.put("Катар","Qatar");
        languageEN.put("Кения","Kenya");
        languageEN.put("Кипр","Cyprus");
        languageEN.put("Киргизия","Kyrgyzstan");
        languageEN.put("Кирибати","Kiribati");
        languageEN.put("Китай","China");
        languageEN.put("КНДР","DPRK");
        languageEN.put("Колумбия","Colombia");
        languageEN.put("Коста-Рика","Costa Rica");
        languageEN.put("Куба","Cuba");
        languageEN.put("Кувейт","Kuwait");
        languageEN.put("Лаос","Laos");
        languageEN.put("Латвия","Latvia");
        languageEN.put("Лесото","Lesotho");
        languageEN.put("Либерия","Liberia");
        languageEN.put("Ливан","Lebanon");
        languageEN.put("Ливия","Libya");
        languageEN.put("Литва","Lithuania");
        languageEN.put("Лихтенштейн","Liechtenstein");
        languageEN.put("Люксембург","Luxembourg");
        languageEN.put("Маврикий","Mauritius");
        languageEN.put("Мавритания","Mauritania");
        languageEN.put("Мадагаскар","Madagascar");
        languageEN.put("Малави","Malawi");
        languageEN.put("Малайзия","Malaysia");
        languageEN.put("Мали","Mali");
        languageEN.put("Мальдивские Острова","Maldives");
        languageEN.put("Мальта","Malta");
        languageEN.put("Марокко","Morocco");
        languageEN.put("Мексика","Mexico");
        languageEN.put("Мозамбик","Mozambique");
        languageEN.put("Молдавия","Moldova");
        languageEN.put("Монако","Monaco");
        languageEN.put("Монголия","Mongolia");
        languageEN.put("Мьянма","Myanmar");
        languageEN.put("Намибия","Namibia");
        languageEN.put("Науру","Nauru");
        languageEN.put("Непал","Nepal");
        languageEN.put("Нигер","Niger");
        languageEN.put("Нигерия","Nigeria");
        languageEN.put("Нидерланды","Netherlands");
        languageEN.put("Никарагуа","Nicaragua");
        languageEN.put("Новая Зеландия","New Zealand");
        languageEN.put("Норвегия","Norway");
        languageEN.put("ОАЭ","UAE");
        languageEN.put("Оман","Oman");
        languageEN.put("Пакистан","Pakistan");
        languageEN.put("Палау","Palau");
        languageEN.put("Панама","Panama");
        languageEN.put("Папуа - Новая Гвинея","Papua New Guinea");
        languageEN.put("Парагвай","Paraguay");
        languageEN.put("Перу","Peru");
        languageEN.put("Польша","Poland");
        languageEN.put("Португалия","Portugal");
        languageEN.put("Республика Конго","Republic of Congo");
        languageEN.put("Республика Корея","Republic of Korea");
        languageEN.put("Россия","Russia");
        languageEN.put("Руанда","Rwanda");
        languageEN.put("Румыния","Romania");
        languageEN.put("Сальвадор","Salvador");
        languageEN.put("Самоа","Samoa");
        languageEN.put("Сан-Марино","San Marino");
        languageEN.put("Саудовская Аравия","Saudi Arabia");
        languageEN.put("Северная Македония","North Macedonia");
        languageEN.put("Сенегал","Senegal");
        languageEN.put("Сент-Люсия","Saint Lucia");
        languageEN.put("Сербия","Serbia");
        languageEN.put("Сингапур","Singapore");
        languageEN.put("Сирия","Syria");
        languageEN.put("Словакия","Slovakia");
        languageEN.put("Словения","Slovenia");
        languageEN.put("Сомали","Somalia");
        languageEN.put("Судан","Sudan");
        languageEN.put("Суринам","Suriname");
        languageEN.put("США","USA");
        languageEN.put("Таджикистан","Tajikistan");
        languageEN.put("Таиланд","Thailand");
        languageEN.put("Танзания","Tanzania");
        languageEN.put("Того","Togo");
        languageEN.put("Тонга","Tonga");
        languageEN.put("Тувалу","Tuvalu");
        languageEN.put("Тунис","Tunisia");
        languageEN.put("Туркмения","Turkmenistan");
        languageEN.put("Турция","Türkiye");
        languageEN.put("Уганда","Uganda");
        languageEN.put("Узбекистан","Uzbekistan");
        languageEN.put("Украина","Ukraine");
        languageEN.put("Уругвай","Uruguay");
        languageEN.put("Фиджи","Fiji");
        languageEN.put("Филиппины","Philippines");
        languageEN.put("Финляндия","Finland");
        languageEN.put("Франция","France");
        languageEN.put("Хорватия","Croatia");
        languageEN.put("ЦАР","CAR");
        languageEN.put("Чад","Chad");
        languageEN.put("Черногория","Montenegro");
        languageEN.put("Чехия","Czech Republic");
        languageEN.put("Чили","Chile");
        languageEN.put("Швейцария","Switzerland");
        languageEN.put("Швеция","Sweden");
        languageEN.put("Шри-Ланка","Sri Lanka");
        languageEN.put("Эквадор","Ecuador");
        languageEN.put("Экваториальная Гвинея","Equatorial Guinea");
        languageEN.put("Эритрея","Eritrea");
        languageEN.put("Эсватини","Eswatini");
        languageEN.put("Эстония","Estonia");
        languageEN.put("Эфиопия","Ethiopia");
        languageEN.put("ЮАР","South Africa");
        languageEN.put("Южный Судан","South Sudan");
        languageEN.put("Ямайка","Jamaica");
        languageEN.put("Япония","Japan");
        //------------------------------------------------
        languageEN.put("Берлин", "Berlin");
        languageEN.put("Ставрополь","Stavropol");
        languageEN.put("Москва","Moscow");

    }

    public static String languageSwitch (String name, String type) {
        if (type.equals("RU")) {
            return languageRU.get(name);
        } else if (type.equals("EN")) {
            return languageEN.get(name);
        }
        return "null";
    }
}



