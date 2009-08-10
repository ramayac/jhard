/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function showLabel(alink){
    alink.style.width = "75px";
    alink.lastChild.style.display = "inline";
}

function hideLabel(alink){
    alink.style.width = "";
    alink.lastChild.style.display = "none";
}