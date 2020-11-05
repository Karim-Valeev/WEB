document.addEventListener('DOMContentLoaded', function () {
    console.log('Check:')
    let btn = document.getElementsByClassName('btn')
    btn[0].addEventListener('click', () => {
        console.log('Click has been made')
        let anvil = document.getElementsByClassName('anvil')[0]
        let start = Date.now();

        let timer = setInterval(function() {
            let timePassed = Date.now() - start;
            anvil.style.top = 0.5*9.81*(timePassed/1000)**2 * 2  + 'px';
            // Расстояние 550 метров
            // за время 10,6 секунд
            console.log('Time passed: ',timePassed/1000, " s")
            console.log('Current speed is: ',9.81*(timePassed/1000), " m/s")
            if (timePassed > 10600) clearInterval(timer);
        }, 20);
    });

    btn[1].addEventListener('click', () => {
        window.location.reload()
        console.log('Page has been reloaded')
    });
})
