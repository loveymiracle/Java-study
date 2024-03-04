import React, { useState } from 'react';

// http://react-ko.dev/

// https://ko.legacy.reactjs.org/docs/hooks-intro.html
// https://ko.legacy.reactjs.org/docs/hooks-reference.html

// State Hook 
// useState는 state를 함수 컴포넌트 안에서 사용할 수 있게 해주는 가장 기본적인 방법
const Counter1 = () => {

    const [number, setNumber] = useState(0);

    return(
        <div>
            <h3>Counter1</h3>
            <p>현재 카운터 값은 <b>{number}</b>입니다.</p>
            <button onClick={(e)=>{
                setNumber(number +1);
            }}>+1</button>
            <button onClick={(e)=> setNumber(number - 1)}>-1</button>
        </div>
    );

}
export default Counter1;
