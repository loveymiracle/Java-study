import React from 'react';


// 클래스로 Component를 구현하는 방법
// - React.Component를 상속하고, render 메소드를 오버라이딩(재정의)하여 사용한다.
// - 이때 props는 this를 통해 접근할수 있다.
// - this.props : html 태그 상에서 입력한 속성값을 연결해주는 매개 변수


class MyComponent2 extends React.Component{
    render(){
        let name = this.props.name  + '님';
        return (
            <div class="box">
                <h1 class="text">클래스로 구현된 Component</h1>
                <div class="text">이름 : {name}</div>
                <div class="text">{`나이 : ${this.props.age}`}</div>
                <div class="text">{`주소 : ${this.props.address}`}</div>
                <div class="text">{`전번 : ${this.props.phone != null ? this.props.phone : '전번이 없습니다.'}`}</div>
            </div>
        )
    }
}

export default MyComponent2;
