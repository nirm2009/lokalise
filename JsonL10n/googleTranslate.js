const apiKey = "AIzaSyDAgPPNdTlsID8mvFwVjml7hL_wUnZq3Tc";

function localize(targetLang, inputToLocalize) {
    let url = "https://translation.googleapis.com/language/translate/v2";
    url += "?key=" + apiKey;
    url += "&q=" + inputToLocalize;
    url += "&target=" + targetLang;

    return $.ajax({
        url: url,
        type: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        success: function(localizedResponse) {
            let localizedJsonStr = localizedResponse.data.translations[0].translatedText;
            let decodedLocalizedJsonStr = decodeHTML(localizedJsonStr);

            downloadLocalizedLangResourceJsonFile(targetLang, decodedLocalizedJsonStr);
        }
    });
}

function decodeHTML(encodedStr) {
    let textArea = document.createElement("textarea");
    textArea.innerHTML = encodedStr;
    return textArea.value;
}

function downloadLocalizedLangResourceJsonFile(localizedLang, jsonStr) {
    const blob = new Blob([jsonStr], {type : 'application/json'});
    let referenceToBlob = URL.createObjectURL(blob);

    let linkToDownloadLocalizedJson = document.createElement('a');
    linkToDownloadLocalizedJson.setAttribute("href", referenceToBlob);
    linkToDownloadLocalizedJson.setAttribute("download", localizedLang + ".json");
    linkToDownloadLocalizedJson.click();
}