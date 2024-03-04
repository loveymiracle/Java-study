import React, {useState} from 'react';


// 함수 컴포넌트에서 useState 사용하기

// props : 컴포넌트가 선언(생성)되는 과정에서 부모 컴포넌트가 설정하는 값들, 
//         또는 외부(html)에서 받아오는 값들, 정적인 값
// state : 컴포넌트 내부에서 상태에 따라 변경되고 사용할수 있는 내부 변수, 
//         동적인 값으로 상태에 따라 변경될 수 있다.
// useState : Returns a stateful value, and a function to update it.


const MyComponent = ()=>{
    // state로 사용할 변수 및 setter 선언부
    // 첫번째 인자 : 사용할 변수, 두번째 인자는 setter, setter로 값을 변경하면 변수값도 변경 된다.
    const [message, setMessage] = useState('초기값');
    const [color, setColor] = useState('black'); // useState의 인자로 초기값을 설정할 수 있다.

    // 이벤트 핸들러 작성할 수 잇다.
    const onClickEnter = ()=>{
        alert('onClickEnter');
        setMessage('안녕하세요?');
    }

    // 단축된 이벤트 핸들러 (), {} 생략
    // e = event 매세지
    const onClickLeave = e => setMessage('안녕히 가세요!');
    

    return(
        <div>
            <button onClick={onClickEnter}>입장</button>
            <button onClick={onClickLeave}>퇴장</button>
            <h1 style={{color}}>{message}</h1>
            <button style={{color:'red'}} onClick={(e)=>{setColor('red');}}>빨간색</button>
            <button style={{color:'green'}} onClick={()=>setColor('green')}>초록색</button>
            <button style={{color:'blue'}} onClick={e=>setColor('blue')}>파란색</button>
        </div>
    )

}

export default MyComponent;
