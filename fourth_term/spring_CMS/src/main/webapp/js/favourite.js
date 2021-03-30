document.addEventListener('DOMContentLoaded', function () {
    // let видна только в блоках {...}
    let dels = document.getElementsByClassName("del");
    let favs = document.getElementsByClassName("fav");
    let bnames = document.getElementsByClassName("bname");

    let i;
    for (i = 0; i < dels.length; i++) {
        let favourite = favs[i].value
        let name = bnames[i].value
        dels[i].addEventListener("click", ()=>{
            if(favourite  === "true"){
                let message = 'Are you sure you want to delete your favourite basket ' + name + '?'
                window.confirm(message)
            }
        });
    }
});