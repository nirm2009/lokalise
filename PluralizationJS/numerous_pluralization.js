import * as numerous from "./numerous-master/lib/numerous.js";
import enLocale from "./numerous-master/locales/en.js";
import ruLocale from "./numerous-master/locales/ru.js";

numerous.registerLocale(enLocale);
numerous.registerLocale(ruLocale);

const pluralFormVariants = {
    en: {
        one: 'apple',
        other: 'apples'
    },
    ru: {
        one: 'яблоко',
        few: 'яблока',
        many: 'яблок'
    }
};

function pluralizeUsingNumerous(langChoice) {
    document.getElementById("apple_count_zero").innerHTML
        = 0 + " " + numerous.pluralize(langChoice, 0, pluralFormVariants[langChoice]);
    document.getElementById("apple_count_one").innerHTML
        = 1 + " " + numerous.pluralize(langChoice, 1, pluralFormVariants[langChoice]);
    document.getElementById("apple_count_few").innerHTML
        = 2 + " " + numerous.pluralize(langChoice, 2, pluralFormVariants[langChoice]);
    document.getElementById("apple_count_many").innerHTML
        = 5 + " " + numerous.pluralize(langChoice, 5, pluralFormVariants[langChoice]);
}

document.getElementById('lang_choice_en').addEventListener('click', function() {
    pluralizeUsingNumerous("en");
});
document.getElementById('lang_choice_ru').addEventListener('click', function() {
    pluralizeUsingNumerous("ru");
});