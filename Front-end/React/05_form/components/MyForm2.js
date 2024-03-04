import React from 'react';

class MyForm2 extends React.Component {
    constructor(props){
        super(props);
        // props값으로 초기화하는 로직,
        // 만일 초기값이 없으면 props 대신 초기 값을 입력하면 된다.
        this.state = {
            nameValue : props.nameValue,
            textValue : props.textValue,
            // ageValue : Number(props.ageValue),
            selectValue : props.selectValue,
            checkEmail : props.checkEmail === 'true' ? true : false, // 체크 박스용도
        }

        // 만일 메소드 형태로 구현하는 경우 bind 코드가 필요
        // handleSubmit(e){}로 만들면 반드시 아래와 같은 코드 필요하다!
        
        // 핸들러 코드를 render에서 사용할 수 있게끔 이어주는 코드
        // this.handleChange = this.handleChange.bind(this);
        // this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange = (e)=>{
        const name = e.target.name;
        const value = e.target.type === 'checkbox' ? e.target.checked:e.target.value;
        this.setState({[name] : value});
    }

    handleSubmit = (e)=>{
        alert('nameValue : ' + this.state.nameValue +
            ', textValue : ' + this.state.textValue +
            ', selectValue : ' + this.state.selectValue +
            ', checkMail : ' + this.state.checkEmail);
        e.preventDefault();
    }

    render(){
        return (
            <div>
                <h3>Class형 Form 구조</h3>
                <form onSubmit={this.handleSubmit}>
                    이름 : <input type="text" name="nameValue" 
                                value={this.state.nameValue}  onChange={this.handleChange} />
                    <br/>
                    자기소개 <br/>
                    <textarea name="textValue" cols="30" rows="10" 
                                value={this.state.textValue} onChange={this.handleChange} />
                    <br/>

                    좋아하는 언어 : &nbsp;
                    <select name="selectValue" value={this.state.selectValue} onChange={this.handleChange}>
                        <option value="C">C</option>
                        <option value="C++">C++</option>
                        <option value="Java">Java</option>
                        <option selected value="JavaScript">JavaScript</option>
                        <option value="Spring">Spring</option>
                    </select>
                    <br/>
                    메일 수신 : 
                    <input type="checkbox" name="checkEmail" checked={this.state.checkEmail} onChange={this.handleChange} />

                    <br/>
                    <input type="submit" value='제출' />
                </form>
            </div>
        )
    }
}

export default MyForm2;
