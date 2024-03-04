import React, { Component } from 'react';
import './ValidationSample.css';

// https://ko.legacy.reactjs.org/docs/forwarding-refs.html

// react는 DOM(html)의 id가 필요없는 구조, 이유는 반복을 시킬수도 있기 때문에 의미 없다.
// 단, id를 지정할일이 발생할수 있다. 
//  -> 해결하기 위해 Ref(컴포넌트 별 ID의 개념)으로 해결 가능

// 자체적으로 createRef를 통해 ID를 할당하는 방법
class ValidationSample extends Component {

    constructor(props){
        super(props);
        this.props = props;
    }

    // React 엘리먼트를 접근할 수 있도록 고유의 키를 발급 받는 과정
    userIdRef =  React.createRef();
    userPasswordRef = React.createRef();

    state = {
        userId : '',
        userPassword : '',
        Clicked : false,
        validated : false,
    }

    onChange = (e)=>{
        this.setState({
            [e.target.name] : e.target.value
        });
    }

    onClick = (e)=>{
        let validated = false;
        if(this.state.userId === this.props.userId
            && this.state.userPassword === this.props.userPassword){
            validated = true;
        }
        this.setState({
            clicked:true,
            validated:validated,
        });
        if(validated === true){
            alert('로그인에 성공하였습니다.');
        }else{
            if(this.state.userId !== this.props.userId){
                this.userIdRef.current.focus();
            }
            if(this.state.userPassword !== this.props.userPassword){
                this.userPasswordRef.current.focus();
            }
        }
    }

    render(){
        return(
            <div>
                <h3>회원 가입</h3>
                아이디 : <input type="text" name="userId" value={this.state.userId}
                            ref={this.userIdRef} onChange={this.onChange}
                            className={this.state.clicked ? (this.state.validated ? 'success' : 'failure'):''} /><br/>
                비밀번호 : <input type="password" name="userPassword" value={this.state.userPassword}
                            ref={this.userPasswordRef} onChange={this.onChange}
                            className={this.state.clicked ? (this.state.validated ? 'success' : 'failure'):''} /><br/>
                <button onClick={this.onClick}>로그인</button>
            </div>
        );
    }

}

export default ValidationSample;
