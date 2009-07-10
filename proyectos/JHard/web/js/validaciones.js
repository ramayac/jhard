
function valNumbers(evt){
    if (evt.keyCode != 8 && evt.keyCode != 9 && evt.keyCode != 127 && !(evt.keyCode >= 37 && evt.keyCode <= 40))
        return (String.fromCharCode(evt.keyCode).match(/\d/g) != null);
    else
        return true;
}