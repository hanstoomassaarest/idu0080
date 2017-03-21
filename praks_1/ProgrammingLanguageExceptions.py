
class Error(Exception):
   """Base class for other exceptions"""
   pass

class ValueTooSmallError(Error):
   """Raised when the input value is too small"""
   pass

class ValueTooLargeError(Error):
   """Raised when the input value is too large"""
   pass
class NotNumberException(Error):
   """Raised when the input value is not integer"""
   pass

def CheckYear(year):
    value = 0.
    try:
        if not year.isdigit():
            raise NotNumberException
        if int(year) < 1900:
            raise ValueTooSmallError
        if int(year) > 2017:
            raise ValueTooLargeError
    except ValueTooSmallError:
        return 'Year must be later than 1900'
    except ValueTooLargeError:
        return 'Year must be less than 2017'
    except NotNumberException:
        return 'Year must only contain numbers'

    return ''