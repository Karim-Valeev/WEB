document.addEventListener('DOMContentLoaded', function () {

    function color(btn){
        let clr = btn.value;
        console.log(clr);
        let box = document.getElementById('box');
        let color_at_the_moment = box.style.backgroundColor;
        // console.log('сейчас такой цвет: ',color_at_the_moment)
        if(clr === "SPECIAL BUTTON"){

            console.log('сейчас такой цвет: ',color_at_the_moment)
            if(color_at_the_moment === "red"){
                clr = 'green'
            }
            else if(color_at_the_moment === "blue"){
                clr = 'red'
            }
            else if(color_at_the_moment === "green"){
                clr = 'blue'
            }
            else{
                clr = 'red'
            }
        }
        box.style.backgroundColor = clr;
    }

    Array.from(document.getElementsByClassName('btn')).forEach(btn => {
        btn.addEventListener("click", () =>
        {
            color(btn)
        });
    });
});