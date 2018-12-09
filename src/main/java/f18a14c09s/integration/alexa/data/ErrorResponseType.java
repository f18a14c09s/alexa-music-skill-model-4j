package f18a14c09s.integration.alexa.data;

public enum ErrorResponseType {
    /**
     * Indicates that the requested operation cannot be performed because the endpoint is already in operation
     * <p>
     * Notes:
     * None
     */
    ALREADY_IN_OPERATION,
    /**
     * Indicates the target bridge endpoint is currently unreachable or offline. For example, the bridge might be turned off, disconnected from the customer's local area network, or connectivity between the bridge and the device cloud might have been lost.
     * <p>
     * Notes:
     * When you respond to a ReportState directive, there may be times when you should return a StateReport instead of this error. See Alexa.EndpointHealth for more details.
     */
    BRIDGE_UNREACHABLE,
    /**
     * Indicates the target endpoint cannot respond because it is performing another action, which may or may not have originated from a request to Alexa.
     * <p>
     * Notes:
     * None
     */
    ENDPOINT_BUSY,
    /**
     * Indicates the directive could not be completed because the target endpoint has low batteries.
     * <p>
     * Notes:
     * None
     */
    ENDPOINT_LOW_POWER,
    /**
     * Indicates the target endpoint is currently unreachable or offline. For example, the endpoint might be turned off, disconnected from the customer's local area network, or connectivity between the endpoint and bridge or the endpoint and the device cloud might have been lost.
     * <p>
     * Notes:
     * When you respond to a ReportState directive, there may be times when you should return a StateReport instead of this error. See Alexa.EndpointHealth for more details.
     */
    ENDPOINT_UNREACHABLE,
    /**
     * Indicates that the authorization credential provided by Alexa has expired. For example, the OAuth2 access token for that customer has expired.
     * <p>
     * Notes:
     * None
     */
    EXPIRED_,
    /**
     * Notes:
     */
    AUTHORIZATION_CREDENTIAL,
    /**
     * Indicates a directive could not be handled because the firmware for a bridge or an endpoint is out of date.
     * <p>
     * Notes:
     * None
     */
    FIRMWARE_OUT_OF_DATE,
    /**
     * Indicates a directive could not be handled because a bridge or an endpoint has experienced a hardware malfunction.
     * <p>
     * Notes:
     * None
     */
    HARDWARE_MALFUNCTION,
    /**
     * Indicates an error that cannot be accurately described as one of the other error types occurred while you were handling the directive. For example, a generic runtime exception occurred while handling a directive. Ideally, you will never send this error event, but instead send a more specific error type.
     * <p>
     * Notes:
     * None
     */
    INTERNAL_ERROR,
    /**
     * Indicates that the authorization credential provided by Alexa is invalid. For example, the OAuth2 access token is not valid for the customer's device cloud account.
     * <p>
     * Notes:
     * None
     */
    INVALID_,
    /**
     * Indicates a directive is not valid for this skill or is malformed.
     * <p>
     * Notes:
     * None
     */
    INVALID_DIRECTIVE,
    /**
     * Indicates a directive contains an invalid value for the target endpoint. For example, use to indicate a request with an invalid heating mode, channel value or program value.
     * <p>
     * Notes:
     * None
     */
    INVALID_VALUE,
    /**
     * Indicates the target endpoint does not exist or no longer exists.
     * <p>
     * Notes:
     * None
     */
    NO_SUCH_ENDPOINT,
    /**
     * Indicates that a directive could not be handled because the target endpoint is in a calibration phase (for example, it's warming up).
     * <p>
     * Notes:
     * None
     */
    NOT_CALIBRATED,
    /**
     * Indicates the target endpoint cannot be set to the specified value because of its current mode of operation.
     * <p>
     * Notes:
     * Requires a currentDeviceModefield that indicates why the device cannot be set to a new value. Valid values are COLOR, ASLEEP, NOT_PROVISIONED, OTHER. See Alexa.ColorTemperatureControlfor an example.
     */
    NOT_SUPPORTED_,
    /**
     * Notes:
     */
    IN_CURRENT_MODE,
    /**
     * Indicates that the requested operation cannot be performed because the endpoint is not in operation. For example, a smart home skill returns a NOT_IN_OPERATION error when it receives a TimeHoldController.Resumedirective, and the endpoint is in the OFF mode.
     * <p>
     * Notes:
     * None
     */
    NOT_IN_OPERATION,
    /**
     * Indicates that an operation was requested with a power level that the endpoint does not support.
     * <p>
     * Notes:
     * None
     */
    POWER_LEVEL_,
    /**
     * Notes:
     */
    NOT_SUPPORTED,
    /**
     * Indicates the maximum rate at which an endpoint or bridge can process directives has been exceeded.
     * <p>
     * Notes:
     * None
     */
    RATE_LIMIT_EXCEEDED,
    /**
     * Indicates a directive that contains a value that outside the numeric temperature range accepted for the target thermostat. For more thermostat-specific errors, see the error section of the Alexa.ThermostatControllerinterface.
     * <p>
     * Notes:
     * Optionally specify the valid range for the temperature using the validRange object. For this error type the minimum and maximum values are Temperature objects. See the TEMPERATURE_
     */
    TEMPERATURE_,
    /**
     * Indicates a directive contains a value that is outside the numerical range accepted for the target endpoint. For example, use to respond to a request to set a percentage value over 100 percent. For temperature values, use TEMPERATURE_VALUE_OUT_OF_RANGE
     * <p>
     * Notes:
     * Optionally specify the valid range using the validRangeobject, which contains minimumValue and maximumValue fields. See the VALUE_OUT_RANGE example.
     */
    VALUE_OUT_OF_RANGE,
    /**
     * Indicates that the user has reached their skip limit. With this error type, the skill can return an optional parameter which Alexa can use to render an error prompt (VUI) or display an error message (GUI) informing the user how long they should wait before trying to skip again.
     */
    SKIP_LIMIT_REACHED
}
