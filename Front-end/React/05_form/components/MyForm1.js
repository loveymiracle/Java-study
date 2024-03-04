import React, { useState } from 'react';

function MyForm1(props) {
    // 1. useState의 정석적인 방법 = 하나씩 선언한다.
    //  - 단점 : 이벤트 함수도 따로 만들어야한다. 
    //     -> 이렇게는 사용하지 않는 걸 권장.
    // const [inputName, setInputName] = useState();
    // const [inputAge, setInputAge] = useState();

    // 2. useState의 응용, 객체로 관리하는 방법 ★★★★★
    // - 장점 : onChange를 한번에 선언할수 있다.  
    // - 단점 : 로직을 고민해야한다. 
    // const [inputs, setInputs] = useState({}); // 아무 값도 안넣고 초기화 방법
    const [inputs, setInputs] = useState({
        inputName : props.inputName,
        inputAge : props.inputAge,
    }); // props를 통해 외부 인자를 state로 초기화 시켜주는 방법

    const onMyChange = (e)=>{
        // inputs[e.target.name] = e.target.value; 이게 되면 좋은데, 안되는 코드!!
        setInputs(inputs => ({...inputs, [e.target.name]:e.target.value}));
        // 함수꼴로 만들어서 next value없이 values 업데이트가 되는 코드
    }

    const onMySubmit = (e)=>{
        // ajax 처리 코드가 와야하는 자리!
        alert(inputs.inputName + ', ' + inputs.inputAge);
        setInputs({inputName:'', inputAge:''});
        e.preventDefault(); // 옵션, 이벤트 전파를 막는 코드
    }

    // https://eunhee-programming.tistory.com/182
    return(
        <div>
            <h3>함수형 form 구조</h3>
            <form onSubmit={onMySubmit}>
                이름 : <input type="text" name="inputName" 
                            value={inputs.inputName || "이름"} onChange={onMyChange} />
                <br />
                나이 : <input type="text" name="inputAge" 
                            value={inputs.inputAge || "나이 입력"} onChange={onMyChange} />
                <br />
                <input type="submit" value="제출" />
            </form>
        </div>
    )
}
export default MyForm1;
