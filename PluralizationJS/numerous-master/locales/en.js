// Custom change to let the library work using vanilla JS - Dasun - GitHub handle nirm2009
// module.exports = {
// Custom change to let the library work using vanilla JS - Dasun - GitHub handle nirm2009
export default {
  id: 'en',
  handler: function pluralize_en(val) {
    const n = Number(val),
      i = Math.floor(Math.abs(val)),
      v = val.toString().replace(/^[^.]*\.?/, '').length;
    if (isNaN(n))
      throw Error('n is not a number');
    if (i === 1 && v === 0)
      return 'one';
    return 'other';
  }
};
