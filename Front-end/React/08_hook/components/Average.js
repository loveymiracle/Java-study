import React, { useState, useMemo, useRef, useCallback } from 'react';

// https://react-ko.dev/reference/react/useMemo

// useMemo(calculateValue, dependencies)
// 리렌더링 사이의 계산 결과를 캐시할 수 있는 React 훅
// memo는 memoization을 뜻하는데 이는 그대로 해석하면 ‘메모리에 넣기’라는 
// 의미이며 컴퓨터 프로그램이 동일한 계산을 반복해야 할 때, 
// 이전에 계산한 값을 메모리에 저장함으로써 동일한 계산의 반복 수행을 
// 제거하여 프로그램 실행 속도를 빠르게 하는 기술이다.

// useCallback
// useCallBack은 useMemo와 같이 리렌더링 사이의 계산 결과를 캐시을 가지고있다.
// useCallback을 사용하지 않으면 이벤트 핸들러 함수는 매번 새로운 인스턴스가 생성된다. 
// 그러나 useCallback을 사용하면 함수가 처음 생성될 때 한 번만 생성되며, 
// 나중에는 동일한 함수 인스턴스를 재사용하게 된다.

const getAverage = (list) => {
    console.log('평균값 계산중..');
    if (list.length === 0) return 0;
    const sum = list.reduce((a, b) => a + b);
    return sum / list.length;
};

const Average = () => {
    const [list, setList] = useState([]);
    const [number, setNumber] = useState('');
    const inputRef = useRef(null);

    const onChange = useCallback(e => {
        setNumber(e.target.value);
    }, []); // 컴포넌트가 처음 렌더링 될 때만 함수 생성

    const onInsert = useCallback(() => {
        const nextList = list.concat(parseInt(number));
        setList(nextList);
        setNumber('');
        inputRef.current.focus();
    }, [number, list]); // number 혹은 list 가 바뀌었을 때만 함수 생성

    const avg = useMemo(() => getAverage(list), [list]);

    return (
        <div>
            <input value={number} onChange={onChange} ref={inputRef} />
            <button onClick={onInsert}>등록</button>
            <ul>
                {list.map((value, index) => (
                    <li key={index}>{value}</li>
                ))}
            </ul>
            <div>
                <b>평균값:</b> {avg}
            </div>
        </div>
    );
};

export default Average;
