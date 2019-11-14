var menuItems = document.querySelectorAll('.menu_item');
    var x = document.getElementById("text").innerText;
    if(x !=""){
        menuItems[2].classList.remove('hidden');
        menuItems[1].classList.add('hidden');
        menuItems[0].classList.remove('hidden');
        
    }

else if(x==""){
    
        menuItems[1].classList.remove('hidden');
        menuItems[2].classList.add('hidden');
        menuItems[0].classList.add('hidden');
    
}