// Copyright (c) PocketCampus.Org 2014
// See LICENSE file for more details
// File author: Solal Pirelli

using ThriftSharp;

namespace PocketCampus.Schedule.Models
{
    /// <summary>
    /// The possible response statuses of server requests.
    /// </summary>
    [ThriftEnum( "ScheduleStatusCode" )]
    public enum ResponseStatus
    {
        /// <summary>
        /// The request completed successfully.
        /// </summary>
        [ThriftEnumMember( "OK", 200 )]
        Ok = 200,

        /// <summary>
        /// A network error occurred while executing the request.
        /// </summary>
        [ThriftEnumMember( "NETWORK_ERROR", 404 )]
        NetworkError = 404,

        /// <summary>
        /// The provided credentials are invalid or expired.
        /// </summary>
        [ThriftEnumMember( "INVALID_SESSION", 407 )]
        AuthenticationError = 407
    }
}