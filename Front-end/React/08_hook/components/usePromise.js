import { useState, useEffect } from 'react';


// usePromise 
// 로딩중 / 완료 / 실패에 대한 상태 관리를 위해 사용되는 패턴

// useEffect
// 컴포넌트가 마운트 됐을 때 (처음 나타났을 때), 언마운트 됐을 때 (사라질 때), 
// 그리고 업데이트 될 때 (특정 props가 바뀔 때) 특정 작업을 처리

export default function usePromise(promiseCreator, deps) {
  const [resolved, setResolved] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const process = async () => {
    setLoading(true);
    try {
      const result = await promiseCreator();
      setResolved(result);
    } catch (e) {
      setError(error);
    }
    setLoading(false);
  };

  useEffect(() => {
    process();
  }, deps);

  return [loading, resolved, error];
}
