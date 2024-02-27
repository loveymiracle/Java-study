import React from 'react'; // import 문, jsx사용을 위해 가져옴

// 함수형으로 컴포넌트를 구현하는 방법
// - 단축된 표현으로 만드는 방법

// 리턴값 : element 값이 되어야한다.
const MyComponent3 = ({name, ...props}) => 

    (
        <div class="box">
            <h1 class="text">함수로 구현된 Component</h1>
            <div class="text">이름 : {name}</div>
            <div class="text">{`나이 : ${props.age}`}</div>
            <div class="text">{`주소 : ${props.address}`}</div>
            <div class="text">{`전번 : ${props.phone != null ? props.phone : '전번이 없습니다.'}`}</div>
        </div>
    )


export default MyComponent3;
