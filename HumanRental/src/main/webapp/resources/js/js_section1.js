var prev=document.querySelector('.prev');
var next=document.querySelector('.next');
var slide=document.querySelector('.c');
var i=document.querySelectorAll('img');

var count=0;

next.addEventListener('click',function(){
  if(count<i.length-1){
    count++;
    slide.style.transform=`translateX(-${count * 500}px)`;
  }
  else if(count=2){
    count=0;
    slide.style.transform=`translateX(-${count * 500}px)`;
  }
})

prev.addEventListener('click',function(){
  if(count>0){
    count--;
    slide.style.transform=`translateX(-${count * 500}px)`;
  }
  else if(count=0){
    count=2;
    slide.style.transform=`translateX(-${count * 500}px)`;
  }
}) 