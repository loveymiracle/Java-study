// 클래스형 컴포넌트로 구현한 EventPractice

import React, { Component } from 'react';

class EventPractice2 extends Component {
    state = {
        userName:'홍길동', 
        message:'',
    }

    onChange = (e)=>{
        this.setState({
            // ...this.state,
            [e.target.name] : e.target.value,
        });
    }

    onKeyDown = (e)=>{
        if (e.key === 'Enter') {
            this.onMyClick();
        }
    }

    onMyClick = (e)=>{
        alert('입력값 : ' + this.state.userName + ', ' + this.state.message);
        // 초기화 하는 방법
        this.setState({
            userName : '',
            message : '',
        });
    }

    render(){
        return (
            <div>
                <h1>이벤트 연습</h1>
                {/* useState에서 사용했던 변수 이름과 input 태그의 name을 일치시켜야한다!*/}
                이름 : <input type="text" name="userName" value={this.state.userName} onChange={this.onChange} />
                <br/>
                메세지 : <input type="text" name="message" value={this.state.message} onChange={this.onChange} 
                            onKeyDown={this.onKeyDown} />
                <br/>
                <button onClick={this.onMyClick}>확인</button>
            </div>
        )
    }
}
export default EventPractice2;
