
var services = (() => {

  function mockResp(resp, timeout) {
    return new Promise(resolve => setTimeout(() => resolve(resp), timeout || 1000))
  }

  const login = (req) => mockResp({ success: true });

  return {
    login
  }
})();