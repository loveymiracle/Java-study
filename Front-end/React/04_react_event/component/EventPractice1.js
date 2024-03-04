import React, { useState } from 'react';

// https://ko.legacy.reactjs.org/docs/handling-events.html

const EventPractice1 = () => {

    // myForm으로 한번에 사용할 변수를 묶어서 관리
    const [myForm, setMyForm] = useState({
        userName: '홍길동',
        message: '',
    });
    const {userName, message} = myForm;

    const onChange = (e)=>{
        // alert('test'); // 이벤트가 발생하는지 확인
        console.log(e); // 실험용 코드, 웬만하면 출력하지 말것!

        // https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Destructuring_assignment
        // 구조할당 문법
        
        // 입력값을 반영한 다음에 변화될 값
        const nextMyForm = {
            ...myForm, // 기존 MyForm에 있는 내용을 해당 객체에 반영하고,
            [e.target.name] : e.target.value, // 업데이트 할 값을 넣는 방법 
        }
        setMyForm(nextMyForm);
    }

    const onKeyDown = (e)=>{
        if(e.key === 'Enter'){
            onMyClick();
        }
    }

    const onMyClick = (e)=>{
        alert('입력값 : ' + userName + ', ' + message);
        // 초기화 하는 방법
        setMyForm({
            userName : '',
            message : '',
        });
    }

    return (
        <div>
            <h1>이벤트 연습</h1>
            {/* useState에서 사용했던 변수 이름과 input 태그의 name을 일치시켜야한다!*/}
            이름 : <input type="text" name="userName" value={userName} onChange={onChange} />
            <br/>
            메세지 : <input type="text" name="message" value={message} onChange={onChange} 
                        onKeyDown={onKeyDown} />
            <br/>
            <button onClick={onMyClick}>확인</button>
        </div>
    )
}

export default EventPractice1;
