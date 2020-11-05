document.addEventListener('DOMContentLoaded', function () {
    document.onmousemove = function (event) {
        let balls = document.getElementsByClassName("ball");
        console.log("X coords: " + event.clientX + ", Y coords: " + event.clientY)

        mx = event.clientX
        my = event.clientY

        for(let i = 0; i<2; i++){
            eyes = document.getElementsByClassName('eye')
            eyes[i].getBoundingClientRect()
            let rect = eyes[i].getBoundingClientRect();

            let middleX = (rect.left+rect.right)/2

            let middleY = (rect.top+rect.bottom)/2
            let resultX, resultY

            let height = rect.bottom-rect.top
            let width  = rect.right-rect.left

            let modLen = Math.sqrt((mx-middleX)**2+(my-middleY)**2)
            // eyes[i].style.borderColor = `rgb(${}, 0, ${})`

            if(Math.sqrt((mx-middleX)**2+(my-middleY)**2) <= 0.75 * (rect.bottom-rect.top)/2){
                resultX = (mx-rect.left) * 100 / width + "%"
                resultY = (my - rect.top) * 100 / height + "%"
            }
            else{
                let coefficient = 0.75*(rect.bottom-rect.top)/2/modLen
                console.log(coefficient)
                resultX = ((mx-middleX)*coefficient + middleX-rect.left) * 100 / width + "%"
                resultY = ((my-middleY)*coefficient + middleY - rect.top) * 100 / height + "%"
            }

            balls[i].style.left = resultX;
            balls[i].style.top = resultY;
            balls[i].style.transform = "translate(-" + resultX + ",-" + resultY + ")";

        }
    }

});