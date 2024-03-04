import React, { useReducer } from 'react';

// https://ko.legacy.reactjs.org/docs/hooks-intro.html
// https://ko.legacy.reactjs.org/docs/hooks-reference.html

// React의 useReducer Hook을 사용 예제
// const [state, dispatch] = useReducer(reducer, initialArg, init)
// useState의 상위 버전으로 reducer를 추가할 수 있는 함수
// (reducer는 이전 상태와 동작을 받아 새 상태를 리턴하는 순수 함수)
// 여러 개의 state 업데이트가 여러 이벤트 핸들러에 분산되어 있는 컴포넌트는 과부하가 걸릴 수 있다. 
// 이러한 경우, reducer를 통해 컴포넌트 외부의 모든 state 업데이트 로직을 통합할 수 있다.

const reducer = (state, action) =>{
    // action.type에 따라 case를 실행하는 문장
    switch (action.type){
        case 'INCREMENT' : return {number : state.number + 1 };
        case 'DECREMENT' : return {number : state.number - 1 };
        default: return state;
    }
}

const Counter2 = () => {
    const [state, dispatch] = useReducer(reducer, {number : 0});

    return(
        <div>
            <h3>Counter2</h3>
            <p>현재 카운터 값은 <b>{state.number}</b>입니다.</p>
            <button onClick={()=> dispatch({type:'INCREMENT'})}>+1</button>
            {/* dispatch : reducer함수를 호출하는 함수, 인자로 특정 case 값을 넘길수 있음 */}
            <button onClick={()=> dispatch({type:'DECREMENT'})}>-1</button>
        </div>
    );
}
export default Counter2;
