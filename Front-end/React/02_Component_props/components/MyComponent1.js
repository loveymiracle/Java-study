import React from 'react'; // import 문, jsx사용을 위해 가져옴

// 함수형으로 컴포넌트를 구현하는 방법
// - 함수의 이름을 통해서 tag 단위로 모듈을 구성할수 있다. 
//   사용 ex) <MyBox01 name="홍길동"/> name은 props와 연결되어 있다.
// - props : html 형식으로 표현할때 사용하는 속성값을 외부에서 넣어줄때 사용하는 인자, 
//           컴포넌트 부모로부터 상속받은 값

// 리턴값 : element 값이 되어야한다.
function MyComponent1(props){
    var name = props.name + '님';

    return (
        <div class="box">
            <h1 class="text">함수로 구현된 Component</h1>
            <div class="text">이름 : {name}</div>
            <div class="text">{`나이 : ${props.age}`}</div>
            <div class="text">{`주소 : ${props.address}`}</div>
            <div class="text">{`전번 : ${props.phone != null ? props.phone : '전번이 없습니다.'}`}</div>
        </div>
    )
}

export default MyComponent1;
