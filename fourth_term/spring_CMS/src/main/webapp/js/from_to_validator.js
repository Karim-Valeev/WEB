document.addEventListener('DOMContentLoaded', function () {
    // let видна только в блоках {...}
    let fp = document.getElementsByClassName("fp")[0];
    let tp = document.getElementsByClassName("tp")[0];
    let fk = document.getElementsByClassName("fk")[0];
    let tk = document.getElementsByClassName("tk")[0];

    const minP = document.getElementsByClassName("minP")[0];
    const maxP = document.getElementsByClassName("maxP")[0];
    const minK = document.getElementsByClassName("minK")[0];
    const maxK = document.getElementsByClassName("maxK")[0];

    console.log(fp.value)
    console.log(tp.value)
    console.log(fk.value)
    console.log(tk.value)
    if (! (isNaN(fp.value) && isNaN(tp.value) && isNaN(fk.value) && isNaN(tk.value)  )){
        fp.value = minP.value
        tp.value = maxP.value
        fk.value = minK.value
        tk.value = maxK.value
    }
});